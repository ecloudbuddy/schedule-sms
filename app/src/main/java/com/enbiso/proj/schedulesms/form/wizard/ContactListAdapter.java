package com.enbiso.proj.schedulesms.form.wizard;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.enbiso.proj.schedulesms.MainActivity;
import com.enbiso.proj.schedulesms.R;
import com.enbiso.proj.schedulesms.data.core.ContactItem;

import java.util.List;

/**
 * Created by farflk on 7/30/2014.
 */
public class ContactListAdapter extends ArrayAdapter<ContactItem> {

    private Context context;
    private int resourceId;
    private List<ContactItem> contactItems;
    private NewWizardDialog wizardDialog;

    public ContactListAdapter(Context context, List<ContactItem> contactItems, NewWizardDialog wizardDialog) {
        super(context, R.layout.contact_list_item, contactItems);
        this.context = context;
        this.resourceId = R.layout.contact_list_item;
        this.contactItems = contactItems;
        this.wizardDialog = wizardDialog;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = initView(convertView);
        final ContactItem contactItem = contactItems.get(position);
        ((TextView)convertView.findViewById(R.id.contact_name)).setText(contactItem.getName("unknown"));
        ((TextView)convertView.findViewById(R.id.contact_number)).setText(contactItem.getPhone());

        if(contactItem.getPhoto(context) != null){
            ((ImageView)convertView.findViewById(R.id.contact_icon)).setImageURI(contactItem.getPhoto(context));
        }else{
            ((ImageView)convertView.findViewById(R.id.contact_icon)).setImageResource(R.drawable.contact);
        }

        return convertView;
    }


    private View initView(View convertView){
        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            return vi.inflate(resourceId, null);
        }else{
            return convertView;
        }
    }
}
