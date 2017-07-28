package com.example.maalgaadi.cardswitch;

import android.animation.FloatEvaluator;
import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    int flag = 0;
    ValueAnimator vAnimator1 = ValueAnimator.ofFloat(1, 20);
    ValueAnimator vAnimator2 = ValueAnimator.ofFloat(1, 20);
    float cy1, cy2, cz1, cz2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CardView cardView1 = (CardView) findViewById(R.id.first_card);
        final CardView cardView2 = (CardView) findViewById(R.id.second_card);

        cardView1.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
        cardView2.setCardBackgroundColor(Color.parseColor("#E8E8E8"));
        final RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) cardView1.getLayoutParams();
        final RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) cardView2.getLayoutParams();

        cy1 = cardView1.getTranslationY();
        cy2 = cardView2.getTranslationY();

        cardView1.bringToFront();
        flag = 1;

        cardView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (flag != 1) {
                    flag = 1;
                    vAnimator1.setRepeatCount(0);
                    vAnimator1.setDuration(300);
                    vAnimator1.setEvaluator(new FloatEvaluator());
                    vAnimator1.setInterpolator(new LinearInterpolator());
                    vAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        float a = 0;

                        @Override
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float av = (float) valueAnimator.getAnimatedValue();

                            if (a != av) {
                                if (av <= 10) {
                                    cardView1.setTranslationY(cy1 - (av));
                                    cardView2.setTranslationY(cy2 + (av));
                                } else if (av > 10) {
                                    cardView1.setTranslationY(cy1 + ((av - 10)));
                                    cardView2.setTranslationY(cy2 - ((av - 10)));
                                    if (av > 12) {
                                        cardView1.bringToFront();
                                        cardView1.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                                        cardView2.setCardBackgroundColor(Color.parseColor("#E8E8E8"));
                                    }
                                }

                                Log.e("Animator 1", "  ++++++" + valueAnimator.getAnimatedValue());
                            }
                            a = av;
                        }
                    });
                    vAnimator1.start();


                    layoutParams1.width = cardView1.getWidth() + 20;
                    cardView1.setLayoutParams(layoutParams1);

                    layoutParams2.width = cardView2.getWidth() - 20;
                    cardView2.setLayoutParams(layoutParams2);
                    cardView1.bringToFront();
                }
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (flag != 2) {
                    flag = 2;
                    vAnimator2.setRepeatCount(0);
                    vAnimator2.setDuration(300);
                    vAnimator2.setEvaluator(new FloatEvaluator());
                    vAnimator2.setInterpolator(new LinearInterpolator());
                    vAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        float a = 0;

                        @Override
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float av = (float) valueAnimator.getAnimatedValue();
                            if (a != av) {
                                if (av <= 10) {
                                    cardView2.setTranslationY(cy2 + (av));
                                    cardView1.setTranslationY(cy1 - (av));
                                } else if (av > 10) {
                                    cardView2.setTranslationY(cy2 - ((av - 10)));
                                    cardView1.setTranslationY(cy1 + ((av - 10)));
                                    if (av > 12) {
                                        cardView2.bringToFront();

                                        cardView2.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                                        cardView1.setCardBackgroundColor(Color.parseColor("#E8E8E8"));
                                    }
                                }
                                Log.e("Animator 1", "  ++++++" + valueAnimator.getAnimatedValue());
                            }
                            a = av;
                        }
                    });
                    vAnimator2.start();

                    layoutParams1.width = cardView1.getWidth() - 20;
                    cardView1.setLayoutParams(layoutParams1);

                    layoutParams2.width = cardView2.getWidth() + 20;
                    cardView2.setLayoutParams(layoutParams2);


                }
            }
        });


    }
}
