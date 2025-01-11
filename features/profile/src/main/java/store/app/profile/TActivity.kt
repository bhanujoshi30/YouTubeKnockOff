package store.app.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ProfileFragment.newInstance())
                .commitNow()
        }
    }
}