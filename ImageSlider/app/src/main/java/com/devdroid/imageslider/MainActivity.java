package com.devdroid.imageslider;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 locationsViewPager = findViewById(R.id.locationViewPager);
        List<TravelLocation> travelLocations = new ArrayList<>();
        TravelLocation travelLocationEiffelTower = new TravelLocation();
        travelLocationEiffelTower.imageUrl = "https://www.rxwallpaper.site/wp-content/uploads/wallpaper-android-paris-tour-eiffel-10-000-fonds-decran-hd-800x800.jpg";
        travelLocationEiffelTower.title = "France";
        travelLocationEiffelTower.location = "Eiffel Tower";
        travelLocationEiffelTower.starRating = 4.8f;
        travelLocations.add(travelLocationEiffelTower);


        TravelLocation travelLocationMountainView = new TravelLocation();
        travelLocationEiffelTower.imageUrl = "https://th.bing.com/th/id/OIP.axclcHVfKZFvcJLuNKzn7AHaE7?pid=ImgDet&rs=1";
        travelLocationEiffelTower.title = "Indonesia";
        travelLocationEiffelTower.location = "Mountain View";
        travelLocationEiffelTower.starRating = 4.5f;
        travelLocations.add(travelLocationMountainView);

        TravelLocation travelLocationTajMahal = new TravelLocation();
        travelLocationEiffelTower.imageUrl = "https://lp-cms-production.imgix.net/news/2018/01/taj-mahal-visitor-limits.jpg?w=1200&sharp=10&vib=20";
        travelLocationEiffelTower.title = "India";
        travelLocationEiffelTower.location = "Taj Mahal";
        travelLocationEiffelTower.starRating = 5.3f;
        travelLocations.add(travelLocationTajMahal);

        TravelLocation travelLocationLakeView = new TravelLocation();
        travelLocationEiffelTower.imageUrl = "https://th.bing.com/th/id/OIP.22fRgVRL0p8zYNx5wS3tcQHaEo?pid=ImgDet&rs=1";
        travelLocationEiffelTower.title = "Canada";
        travelLocationEiffelTower.location = "Lake View";
        travelLocationEiffelTower.starRating = 4.3f;
        travelLocations.add(travelLocationLakeView);

        locationsViewPager.setAdapter(new TravelLocationAdapter(travelLocations));
        locationsViewPager.setClipToPadding(false);
        locationsViewPager.setClipChildren(false);
        locationsViewPager.setOffscreenPageLimit(3);
        locationsViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float  r = 1-Math.abs(position);
                page.setScaleY(0.95f+r*0.95f);
            }
        });
        locationsViewPager.setPageTransformer(compositePageTransformer);

    }
}