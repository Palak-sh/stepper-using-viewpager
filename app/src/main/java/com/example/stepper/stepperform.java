package com.example.stepper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stepper.adapter.ViewPagerAdapter;
import com.example.stepper.fragments.Hobby_Fragment;
import com.example.stepper.fragments.Personal_Details_Fragment;
import com.example.stepper.fragments.Qualification_Fragment;
import com.example.stepper.fragments.Work_Experience_Fragment;
import com.google.android.material.textfield.TextInputEditText;
import com.shuhart.stepview.StepView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class stepperform extends AppCompatActivity {
    @BindView(R.id.step)
    StepView step;
    @BindView(R.id.view_pager)
    ViewPager view_pager;
    @BindView(R.id.next_btn)
    Button next;
    @BindView(R.id.back_btn)
            Button back;
    boolean check = false;
    int currentposition;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stepperform);
        ButterKnife.bind(this);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        view_pager.setAdapter(viewPagerAdapter);





//        view_pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
//            @Override
//            public void onPageSelected(int position) {
//                super.onPageSelected(position);
//
//                if(position == 0){
//
//
//                }else if(position == 1){
//
//                    step.go(1,false);
//
//
//                }else if(position == 2){
//
//                    step.go(2,true);
//
//
//                }else{
//
//                    step.go(3,true);
//                }
//            }
//        });

        view_pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {




                if(position == 0){
                    back.setVisibility(View.GONE);
                    Personal_Details_Fragment p = (Personal_Details_Fragment) view_pager
                            .getAdapter()
                            .instantiateItem(view_pager, position);
                    check = p.Validations();
                    if (p.Validations()) {
                        check = true;
                        view_pager.setCurrentItem(position + 1, true);
                        step.go(1,true);
                    } else {
                        check =false;
                        view_pager.setCurrentItem(position,true);
                    }

                }else if(position == 1){

                    back.setVisibility(View.VISIBLE);
                    Qualification_Fragment q = (Qualification_Fragment) view_pager
                            .getAdapter()
                            .instantiateItem(view_pager,position);
                    check=q.Validations();
                    if(q.Validations()) {
                        check =true;
                        view_pager.setCurrentItem(position +1, true);
                        step.go(2,true);
                    }else{

                      /*  if(currentposition < position){
                            view_pager.getAdapter().instantiateItem(view_pager,position -1);
                            view_pager.setCurrentItem(position -1,true);
                        }else {*/
                            check = false;
                            view_pager.setCurrentItem(position, false);

//                        }

                    }

                }else if(position == 2){

                    back.setVisibility(View.VISIBLE);

                    Work_Experience_Fragment w = (Work_Experience_Fragment) view_pager
                            .getAdapter()
                            .instantiateItem(view_pager,position);
                    check=w.Validations();
                    if(w.Validations()){
                        check=true;
                        view_pager.setCurrentItem(position+1, true);
                        step.go(3,true);
                    }else{
                        check =false;

                            view_pager.setCurrentItem(position,true);

                    }

                }else{

                    back.setVisibility(View.VISIBLE);
                    Hobby_Fragment h = (Hobby_Fragment) view_pager
                            .getAdapter()
                            .instantiateItem(view_pager,position);
                    check= h.Validations();
                    if(h.Validations()){
                        check =true;
                        Toast.makeText(stepperform.this, "valid", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        check =false;
                        view_pager.setCurrentItem(position,true);

                    }

                }

            }

            @Override
            public void onPageSelected(int position) {



              /*  if(position == 0){


                }else if(position == 1){

                    view_pager.setCurrentItem(position-1,true);

                    step.go(1,true);


                }else if(position == 2){

                    step.go(2,true);


                }else{

                    step.go(3,true);
                }*/

            }

            @Override
            public void onPageScrollStateChanged(int state) {

               /* if(view_pager.getCurrentItem()!=0){
                    view_pager.setCurrentItem(view_pager.getCurrentItem()-1,false);
                }else{
                    finish();
                }*/

            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(view_pager.getCurrentItem()==0) {
                    Personal_Details_Fragment p = (Personal_Details_Fragment) view_pager
                            .getAdapter()
                            .instantiateItem(view_pager, view_pager.getCurrentItem());
                    check = p.Validations();
                    if (p.Validations()) {
                        check = true;
                        view_pager.setCurrentItem(view_pager.getCurrentItem() + 1, true);
                    } else {
                        Toast.makeText(stepperform.this, "invalid", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(view_pager.getCurrentItem() == 3){
                    Hobby_Fragment h = (Hobby_Fragment) view_pager
                            .getAdapter()
                            .instantiateItem(view_pager,view_pager.getCurrentItem());
                    check= h.Validations();
                    if(h.Validations()){
                        check =true;
                        Toast.makeText(stepperform.this, "valid", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(stepperform.this, "invalid", Toast.LENGTH_SHORT).show();
                    }
                }else if(view_pager.getCurrentItem() ==1){
                    Qualification_Fragment q = (Qualification_Fragment) view_pager
                            .getAdapter()
                                    .instantiateItem(view_pager,view_pager.getCurrentItem());
                    check=q.Validations();
                    if(q.Validations()) {
                        check =true;
                        view_pager.setCurrentItem(view_pager.getCurrentItem() + 1, true);
                    }else{
                        Toast.makeText(stepperform.this, "invalid", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Work_Experience_Fragment w = (Work_Experience_Fragment) view_pager
                            .getAdapter()
                            .instantiateItem(view_pager,view_pager.getCurrentItem());
                    check=w.Validations();
                    if(w.Validations()){
                        check=true;
                        view_pager.setCurrentItem(view_pager.getCurrentItem() + 1, true);
                    }else{
                        Toast.makeText(stepperform.this, "invalid", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(view_pager.getCurrentItem()==0) {

                }
                else if(view_pager.getCurrentItem() == 3){
                    view_pager.setCurrentItem(view_pager.getCurrentItem() -1, true);
                }else if(view_pager.getCurrentItem() ==1){
                    view_pager.setCurrentItem(view_pager.getCurrentItem() - 1, true);
                }else {
                    view_pager.setCurrentItem(view_pager.getCurrentItem() - 1, true);
                }

            }
        });
    }
    @Override
    public void onBackPressed() {

        if (view_pager.getCurrentItem() != 0) {
            view_pager.setCurrentItem(view_pager.getCurrentItem() - 1,false);
        }else{

            finish();
        }

    }
}