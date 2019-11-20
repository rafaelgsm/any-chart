package rafaelgsm.example.data_visualization

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController

/**
 * Just acting as a container from the Navigation component.
 */
class MainActivity : AppCompatActivity() {

    private val nav by lazy { findNavController(R.id.navHost) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
