package uk.org.linuxgrotto.tocrunch.connect;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.nio.charset.Charset;

/**
 * Created by jgroth on 26/05/16.
 */
public class ToCrunchFormHttpMessageConverter extends FormHttpMessageConverter {
    private Charset charset = Charset.forName("UTF-8");

    @Override
    public MultiValueMap<String, String> read(Class<? extends MultiValueMap<String, ?>> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        MediaType contentType = inputMessage.getHeaders().getContentType();
        Charset charset;
        if (contentType != null) {
            charset = contentType.getCharSet() != null ? contentType.getCharSet() : this.charset;
        } else {
            charset = this.charset;
        }
        String body = FileCopyUtils.copyToString(new InputStreamReader(inputMessage.getBody(), charset));

        String[] pairs = StringUtils.tokenizeToStringArray(body, "&");

        MultiValueMap<String, String> result = new LinkedMultiValueMap<>(pairs.length);

        for (String pair : pairs) {
            int idx = pair.indexOf('=');
            if (idx == -1) {
                result.add(URLDecoder.decode(pair, charset.name()), null);
            } else {
                String name = URLDecoder.decode(pair.substring(0, idx), charset.name());
                String value = URLDecoder.decode(pair.substring(idx + 1), charset.name());
                result.add(name, value);
            }
        }
        return result;
    }
}
