package com.example.onbid.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.onbid.Login
import com.example.onbid.R
import com.example.onbid.data.ViewModel
import com.example.onbid.hometab
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_fragment5.*
import me.piruin.quickaction.ActionItem
import me.piruin.quickaction.QuickAction
import me.piruin.quickaction.QuickIntentAction

class fragment5 : Fragment() {
    val viewModel: ViewModel by viewModels()
    private lateinit var auth : FirebaseAuth
    private val QuickAction : QuickAction?=null
    private val QuickIntent : QuickAction?=null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_fragment5,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //로그인 정보 확인
        auth = FirebaseAuth.getInstance()
        //로그인 하러 가기
        if(auth.currentUser==null) {
            linear_gologin.visibility=View.VISIBLE
            linear_login_visible.visibility=View.GONE
            linear_gologout.visibility=View.GONE

        }else {
            linear_gologin.visibility=View.GONE
            linear_login_visible.visibility=View.VISIBLE
            linear_gologout.visibility=View.VISIBLE
            text_myname.setText(""+auth.currentUser)
        }

        image_quickaction.setOnClickListener{
            quickActivity()
        }
        linear_gologin.setOnClickListener {
            startActivity(Intent(context,Login::class.java))
        }
        linear_gologout.setOnClickListener {
            auth.signOut()
            startActivity(Intent(context,hometab::class.java))
        }

    }
    fun quickActivity() {
        QuickAction?.setColor(999)
        QuickAction?.setTextColor(333)
        val item = ActionItem(1,"여기에 적을꺼 뭐 적지")
        val quickAction = QuickAction(requireContext(),me.piruin.quickaction.QuickAction.VERTICAL)
        quickAction.setColorRes(R.color.gray6)
        quickAction.setTextColorRes(R.color.ourcolor)
        quickAction.addActionItem(item)
        quickAction.setOnActionItemClickListener { }
        val intent = Intent()
        intent.setAction(Intent.ACTION_SEND)
        val quickIntent = QuickIntentAction(context)
            .setActivityIntent(intent)
            .create()
        quickIntent.setAnimStyle(me.piruin.quickaction.QuickAction.Animation.GROW_FROM_CENTER)
        quickAction.show(image_quickaction)
    }
}