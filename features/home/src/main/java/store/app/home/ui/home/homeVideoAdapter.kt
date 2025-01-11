package store.app.home.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import store.app.home.databinding.ItemVideoCardBinding

class HomeVideoAdapter:RecyclerView.Adapter<HomeVideoAdapter.VideoViewHolder>() {


    inner class VideoViewHolder(private val mView:ItemVideoCardBinding):RecyclerView.ViewHolder(mView.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(ItemVideoCardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {

    }
}