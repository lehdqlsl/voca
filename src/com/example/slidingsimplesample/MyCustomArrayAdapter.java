package com.example.slidingsimplesample;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MyCustomArrayAdapter extends ArrayAdapter<Model> {

	private final List<Model> list;
	private final Activity context;

	public MyCustomArrayAdapter(Activity context, List<Model> list) {
		super(context, R.layout.list_layout, list);
		this.context = context;
		this.list = list;

	}

	static class ViewHolder {
		protected TextView text, sub;
		protected CheckBox checkbox;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		if (convertView == null) {

			LayoutInflater inflator = context.getLayoutInflater();
			view = inflator.inflate(R.layout.list_layout, null);
			final ViewHolder viewHolder = new ViewHolder();

			viewHolder.text = (TextView) view.findViewById(R.id.label);
			viewHolder.text.setTextColor(Color.BLACK);

			// viewHolder.sub = (TextView) view.findViewById(R.id.sub);
			// viewHolder.sub.setTextColor(Color.GRAY);

			viewHolder.checkbox = (CheckBox) view.findViewById(R.id.check);
			viewHolder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					Model element = (Model) viewHolder.checkbox.getTag();
					element.setSelected(buttonView.isChecked());
					System.out.println("Checked : " + element.getName());
				}
			});
			view.setTag(viewHolder);
			viewHolder.checkbox.setTag(list.get(position));
		} else {
			view = convertView;
			((ViewHolder) view.getTag()).checkbox.setTag(list.get(position));
		}
		ViewHolder holder = (ViewHolder) view.getTag();
		holder.text.setText(list.get(position).getName());
		// holder.sub.setText(list.get(position).getPlace());
		holder.checkbox.setChecked(list.get(position).isSelected());
		return view;
	}
}