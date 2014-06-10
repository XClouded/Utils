package com.lxl.uustock_android_utils;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

public abstract class UtkAdapter extends BaseAdapter {
	public LayoutInflater layoutInflater;
	public List<Object> datas = new ArrayList<Object>();

	public UtkAdapter(Context context) {
		layoutInflater = LayoutInflater.from(context);
	}

	/**
	 * 添加数据。
	 * 
	 * @param data
	 */
	public void putData(Object data) {
		@SuppressWarnings("unchecked")
		List<Object> list = (List<Object>) data;
		datas.addAll(list);
	}

	/**
	 * 刷新ui。
	 */
	public void upDataUi() {
		notifyDataSetChanged();
	}

	/**
	 * 更新数据子项。
	 * 
	 * @param index
	 * @param object
	 */
	public void upDataItem(int index, Object object) {
		datas.remove(index);
		datas.add(index, object);
	}

	/**
	 * 删除所有。
	 */
	public void deleteAll() {
		datas.clear();
	}

	/**
	 * 删除指点索引的元素。
	 * 
	 * @param from
	 * @param to
	 */
	public void delete(int from, int to) {
		int size = getCount();
		if (from < 0) {
			from = 0;
		}
		if (to < 0) {
			to = 0;
		}
		if (from <= size && to <= size && from < to) {
			List<Object> list = datas.subList(from, to);
			List<Object> list2 = new ArrayList<Object>();
			for (Object object : list) {
				list2.add(object);
			}
			datas.removeAll(list2);
		}
	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return datas.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO 自动生成的方法存根
		return datas.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO 自动生成的方法存根
		return position;
	}

}
