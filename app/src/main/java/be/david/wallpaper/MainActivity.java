package be.david.wallpaper;

import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.GridView1);

        gridView.setAdapter(new ImageAdapter(this));

        registerForContextMenu(gridView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Context menu");
        AdapterView.AdapterContextMenuInfo cmi = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.add(1,cmi.position, 0, "Set as wallpaper");
        menu.add(2,cmi.position,0, "View Image");



    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
//        return super.onContextItemSelected(item);

        Integer resourceId = (Integer) gridView.getItemAtPosition(item.getItemId());

        switch (item.getGroupId()) {

            case 1:
                    final WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

                try {
                    wallpaperManager.setResource(resourceId);
                    Toast.makeText(getApplicationContext(),"Your wallpaper has been changed", Toast.LENGTH_LONG).show();



                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:

                Intent i = new Intent(MainActivity.this,ImagePreview.class);
                i.putExtra("id", resourceId);
                startActivity(i);
                break;


        }

        return true;
    }
}
