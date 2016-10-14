package be.david.wallpaper;

import android.app.ActionBar;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by David on 14/10/2016.
 */

public class ImageAdapter extends BaseAdapter {

    public Integer[] mThumbIds = {

            R.mipmap.ffxiv_spw15001_1440x1280_en,
            R.mipmap.ffxiv_spw16001_1440x1280_en,
            R.mipmap.ffxiv_spw17001_1440x1280_en,
            R.mipmap.ffxiv_spw19002_1440x1280_en,
            R.mipmap.ffxiv_spw19001_1440x1280_en
//            R.mipmap.ffxiv_spw20001_1440x1280_en,
//            R.mipmap.ffxiv_spw23002_1440x1280,
//            R.mipmap.ffxiv_spw23003_1440x1280,
//            R.mipmap.ffxiv_spw23004_1440x1280,
//            R.mipmap.ffxiv_spw24002_1440x1280,
//            R.mipmap.ffxiv_spw25001_1440x1280,
//            R.mipmap.ffxiv_spw26002_1440x1280,
//            R.mipmap.ffxiv_spw27001_2880x2560
    };

    private Context context;

    public ImageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = new ImageView(context);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(GridLayout.LayoutParams.WRAP_CONTENT, 200));


        return imageView;
    }
}
