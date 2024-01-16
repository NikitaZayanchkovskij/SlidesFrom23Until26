package com.example.designslidefrom23until26.fragments


import android.app.AlertDialog
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.designslidefrom23until26.R
import com.example.designslidefrom23until26.adapters.FirstAndFifthScreenAdapter
import com.example.designslidefrom23until26.databinding.FifthFragmentHomeBinding
import com.example.designslidefrom23until26.users_and_items.User
import com.example.designslidefrom23until26.utils.ProgressDialog


class FifthFragmentHome(private val userList: ArrayList<User>): Fragment() {
    private lateinit var binding: FifthFragmentHomeBinding
    private val adapter = FirstAndFifthScreenAdapter()
    private var clearTheList: MenuItem? = null
    private lateinit var timer: CountDownTimer


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FifthFragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpToolBar()
        initRecyclerView()
        refreshWithSwipeToRefresh()
    }

    override fun onStop() {
        super.onStop()
        timer.cancel()
    }


    /** Функция настраивает кнопку меню "Очистить список" в ToolBar-е.
     */
    private fun setUpToolBar() {
        binding.tbFifthScreen.inflateMenu(R.menu.fifth_fragment_toolbar_menu)

        clearTheList = binding.tbFifthScreen.menu.findItem(R.id.clear_the_list)

        /* Кнопка очистить список. */
        clearTheList!!.setOnMenuItemClickListener {

            adapter.submitList(null)

            binding.tvEmpty.visibility = View.VISIBLE

            true
        }
    }


    /** Функция инициализирует RecyclerView и инициализирует задержку заполнения данными в 6 секунд.
     */
    private fun initRecyclerView() = with(binding) {
        val progressDialog = ProgressDialog.createProgressDialog(activity as AppCompatActivity)

        rcViewFifthScreen.layoutManager = LinearLayoutManager(activity)
        rcViewFifthScreen.adapter = adapter
        startTimer(adapter, progressDialog, 6000L)
    }


    /** Запускается когда пользователь потянул вниз пальцем т.е. запустил SwipeToRefresh.
     */
    private fun refreshWithSwipeToRefresh() {

        /* Слушатель смахивания SwipeToRefresh.
         */
        binding.swipeRefreshLayout.setOnRefreshListener {

            val progressDialog = ProgressDialog.createProgressDialog(activity as AppCompatActivity)

            adapter.submitList(null)

            if (binding.tvEmpty.visibility == View.VISIBLE) binding.tvEmpty.visibility = View.GONE

            startTimer(adapter, progressDialog, 3000L)

            /* Это нужно чтобы бесконечно не висело колёсико загрузки (progress bar) после того,
             * как мы потянули пальцем вниз, чтобы обновить информацию.
             */
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }


    /** По прошествии 6 или 3 секунд (в зависимости от того запускается ли задержка при обычном
     * открытии экрана, или после использования SwipeToRefresh) экран заполняется данными.
     */
    private fun startTimer(adapter: FirstAndFifthScreenAdapter, progressDialog: AlertDialog, delayTime: Long) {

        timer = object: CountDownTimer(delayTime, 1000) {

            override fun onTick(timeLeft: Long) {}

            override fun onFinish() {
                adapter.submitList(userList)
                progressDialog.cancel()
            }
        }.start()
    }



}