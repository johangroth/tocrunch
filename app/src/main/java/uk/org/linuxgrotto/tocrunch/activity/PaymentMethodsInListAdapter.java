package uk.org.linuxgrotto.tocrunch.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import uk.org.linuxgrotto.tocrunch.api.model.PaymentMethods;

/**
 * Created by jgroth on 05/06/16.
 */
public class PaymentMethodsInListAdapter extends BaseAdapter {

    private PaymentMethods paymentMethods;
    LayoutInflater layoutInflater;

    public PaymentMethodsInListAdapter(Context context, PaymentMethods paymentMethods) {
        if (paymentMethods == null) {
            throw new IllegalArgumentException("PaymentMethods cannot be null");
        }
        this.paymentMethods = paymentMethods;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public String[] getItem(int pos) {
        String[] item = new String[2];

        switch (pos) {
            case 0:
                item[0] = "paymentMethodDisplayName";
                item[1] = paymentMethods.getPaymentMethod().get(0).getPaymentMethodDisplayName();
                break;
            case 1:
                item[0] = "requiredElement";
                item[1] = paymentMethods.getPaymentMethod().get(0).getRequiredElement();
                break;
            case 2:
                item[0] = "paymentMethodName";
                item[1] = paymentMethods.getPaymentMethod().get(0).getPaymentMethodName();
                break;
            default:
                item[0] = "";
                item[1] = "";
                break;
        }
        return item;
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        String[] item = getItem(pos);
        View view = convertView;

        if (view == null) {
            view = layoutInflater.inflate(android.R.layout.two_line_list_item, parent, false);
        }

        TextView textView = (TextView) view.findViewById(android.R.id.text1);
        textView.setText(item[0]);

        textView = (TextView) view.findViewById(android.R.id.text2);
        textView.setText(item[1]);

        return view;
    }
}
