package cz.iqlandia.iqplanetarium.starshiptoolsclient;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import cz.iqlandia.iqplanetarium.starshiptoolsclient.databinding.ActivityMainBinding;
import cz.iqlandia.iqplanetarium.starshiptoolsclient.network.NetworkAdapter;

public class MainActivity extends AppCompatActivity {

	private ActivityMainBinding binding;
	public static NetworkAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		adapter = new NetworkAdapter("http://192.168.99.64:8765") {
			@Override
			public void onError(String error) {
				Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
			}
		};
		super.onCreate(savedInstanceState);

		binding = ActivityMainBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());

		BottomNavigationView navView = findViewById(R.id.nav_view);
		// Passing each menu ID as a set of Ids because each
		// menu should be considered as top level destinations.
		AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
				R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
				.build();
		NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
		NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
		NavigationUI.setupWithNavController(binding.navView, navController);
	}


}