package com.mp.speach_to_text.B;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPaperAdapter extends PagerAdapter {

    private Context context;
    private Bitmap[] images;
    private int pos = 0;

    public ViewPaperAdapter(Context context, Bitmap[] images) {
        this.context = context;
        this.images = images;
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((View)object);
    }
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int postition ) {
        final ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        ((ViewPager)container).addView(imageView);
        imageView.setImageBitmap(images[pos]);
        if (pos >= images.length - 1)
        {
            pos = 0;
        }
        else
            pos++;
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager)container).removeView((View)object);
    }
}
