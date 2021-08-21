package com.example.animation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Здаем константы для ID пунктов меню
    final int ALPHA_ID = 1;
    final int SCALE_ID = 2;
    final int ROTATE_ID = 3;
    final int COMBO_ID = 4;
    final int TRANS_ID = 5;

    // Создаем переменную
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text1);
        //Регестрируем контекст для меню
        registerForContextMenu(text);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        switch (v.getId()){
            case R.id.text1:
                menu.add(0,ALPHA_ID,0,"Alpha");
                menu.add(0,TRANS_ID,0,"Trans");
                menu.add(0,COMBO_ID,0,"Combo");
                menu.add(0,ROTATE_ID,0,"Rotate");
                menu.add(0,SCALE_ID,0,"Scale");
                break;
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Animation anim = null;
        switch (item.getItemId()){
            case ALPHA_ID:
                anim = AnimationUtils.loadAnimation(this,R.anim.alpha);
                break;
            case SCALE_ID:
                anim= AnimationUtils.loadAnimation(this,R.anim.scale);
                break;
            case ROTATE_ID:
                anim= AnimationUtils.loadAnimation(this,R.anim.rotate);
                break;
            case COMBO_ID:
                anim= AnimationUtils.loadAnimation(this,R.anim.combo);
                break;
            case TRANS_ID:
                anim= AnimationUtils.loadAnimation(this,R.anim.trans);
                break;
        }

        text.startAnimation(anim);
        return super.onContextItemSelected(item);
    }
}