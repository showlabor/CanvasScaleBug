/*
 * 
 * @author Felix Homann (linuxaudio@showlabor.de)
 * 
 * I don't think this file contains any copyrightable code.
 * So regard it as public domain code.
 * 
 */

package de.showlabor.canvasscalebug;

import de.showlabor.canvasscalebug.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	
	private ScaleBugView bugView;
	private ToggleButton hwToggle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Canvas scale bug");
        setContentView(R.layout.activity_main);
        
        bugView = (ScaleBugView) findViewById(R.id.scaleBugView1);
        bugView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        
        hwToggle = (ToggleButton) findViewById(R.id.toggleButton);
        
        hwToggle.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int layerType = bugView.getLayerType();
				if (layerType == View.LAYER_TYPE_SOFTWARE) {
					bugView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
				} else {
					bugView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
				}				
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
