package store.app.home.ui.home.home

import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter(val onclick:()->Unit) : RecyclerView.Adapter<HomeAdapter.MyVH>() {

    inner class MyVH(private val composeView: ComposeView) :RecyclerView.ViewHolder(composeView){

        fun onBind(position: Int){
            composeView.setContent {
              //  itemVideoPlayer(LocalContext.current,onclick)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        val view=ComposeView(parent.context).apply {
            layoutParams=ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        }
        return MyVH(view)
    }

    override fun getItemCount() = 8

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        holder.onBind(position)
    }
}