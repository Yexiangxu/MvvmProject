package com.lazyxu.film.ui

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lazyxu.film.BR
import com.lazyxu.film.R
import com.lazyxu.film.data.entity.FilmItemEntity

/**
 * User: xuyexiang
 * Date: 2019/06/13
 * Description:
 * FIXME
 */
class HotFilmAdapter(layoutResId: Int, data: List<FilmItemEntity>?) : BaseQuickAdapter<FilmItemEntity, HotFilmAdapter.HotFilmHolder>(layoutResId, data) {

    override fun convert(helper: HotFilmHolder, item: FilmItemEntity) {
        val binding = helper.binding
        binding.setVariable(BR.filmItemEntity, item)
        binding.executePendingBindings()
    }

    override fun getItemView(layoutResId: Int, parent: ViewGroup): View {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(mLayoutInflater, layoutResId, parent, false)
                ?: return super.getItemView(layoutResId, parent)
        val view = binding.root
        view.setTag(R.id.BaseQuickAdapter_databinding_support, binding)
        return view
    }

    class HotFilmHolder(view: View) : BaseViewHolder(view) {

        val binding: ViewDataBinding
            get() = itemView.getTag(R.id.BaseQuickAdapter_databinding_support) as ViewDataBinding
    }
    /**
    public static class HotFilmHolder extends BaseViewHolder {
    public HotFilmHolder(View view) {
    super(view);
    }

    public ViewDataBinding getBinding() {
    return (ViewDataBinding) itemView.getTag(R.id.BaseQuickAdapter_databinding_support);
    }
    }
     */
}
