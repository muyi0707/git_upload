package com.andbase;

import java.util.HashMap;

import com.andbase.R;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.onekeyshare.OnekeyShareTheme;
import cn.sharesdk.onekeyshare.Shake2Share;
import cn.sharesdk.onekeyshare.Shake2Share.OnShakeListener;
import cn.sharesdk.onekeyshare.ShareContentCustomizeCallback;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.system.text.ShortMessage;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.favorite.WechatFavorite;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener {

	Button qQLoginBtn,weChatBtn,oneShareBtn,sinaWeiboBtn,weChatLoginBtn,smsBtn;
	MyLostener myLostener;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShareSDK.initSDK(this);
//        SMSSDK.initSDK(this,"9694a958d4f4","2695b75d14033b395b120ffd3403944b",false);
        init();
//        ShareSDK.stopSDK();
    }

    private void init() {
    	myLostener=new MyLostener();
    	qQLoginBtn=(Button) findViewById(R.id.QQ_login_btn);
    	qQLoginBtn.setOnClickListener(this);
    	weChatBtn=(Button) findViewById(R.id.WeChat_btn);
    	weChatBtn.setOnClickListener(this);
    	weChatLoginBtn=(Button) findViewById(R.id.WeChat_login_btn);
    	weChatLoginBtn.setOnClickListener(this);
    	oneShareBtn=(Button) findViewById(R.id.OneShare_btn);
    	oneShareBtn.setOnClickListener(this);
    	sinaWeiboBtn=(Button) findViewById(R.id.sina_btn);
    	sinaWeiboBtn.setOnClickListener(this);
    	smsBtn=(Button) findViewById(R.id.sms_btn);
    	smsBtn.setOnClickListener(this);
	}
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.QQ_login_btn:
				Platform xinlang=ShareSDK.getPlatform(SinaWeibo.NAME);
				xinlang.isClientValid()
				xinlang.setPlatformActionListener(new PlatformActionListener() {
					
					@Override
					public void onError(Platform arg0, int arg1, Throwable arg2) {
						Log.i("tag", "onError");
					}					
					@Override
					public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
						// TODO Auto-generated method stub
						Log.i("tag", "onComplete"+arg2.toString());	
						Log.i("tag", "onComplete");	
						
					}				
					@Override
					public void onCancel(Platform arg0, int arg1) {
						// TODO Auto-generated method stub
						Log.i("tag", "onCancel");					
					}
				});		
				xinlang.SSOSetting(true);
				xinlang.showUser(null);
//				xinlang.authorize();
				break;
			case R.id.WeChat_login_btn:
				
				Platform xinlang2=ShareSDK.getPlatform(SinaWeibo.NAME);
				xinlang2.removeAccount();	
				ShareSDK.removeCookieOnAuthorize(true);				
				if (xinlang2.isAuthValid()) {
				}
				xinlang2.SSOSetting(true);
				xinlang2.showUser(null);
				Toast.makeText(this, "text"+xinlang2.isAuthValid(), 1).show();//isAuthValid 这个是判断是否授权
				break;
			case R.id.WeChat_btn:		
				ShareParams sps=new ShareParams();
				sps.setTitle("为你APP");
				sps.setTitleUrl("http://www.baidu.com");	
				sps.setImageUrl("http://wiki.mob.com/wp-content/uploads/2014/09/ssdk_qig_qi_win.png");
				sps.setText("test   http://www.baidu.com");
				sps.setShareType(Platform.SHARE_WEBPAGE);
				Platform weixin=ShareSDK.getPlatform(Wechat.NAME);
				
				weixin.setPlatformActionListener(new PlatformActionListener() {
					
					@Override
					public void onError(Platform arg0, int arg1, Throwable arg2) {
						// TODO Auto-generated method stub
						Log.i("tag", ""+arg2);
					}
					
					@Override
					public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onCancel(Platform arg0, int arg1) {
						// TODO Auto-generated method stub
						
					}
				});
				weixin.share(sps);
				break;
			case R.id.OneShare_btn:
//				Platform sinaWeibo=ShareSDK.getPlatform(SinaWeibo.NAME);
//				sinaWeibo.removeAccount();	
//				ShareSDK.removeCookieOnAuthorize(true);
//				oks.addHiddenPlatform(SinaWeibo.NAME);
				OnekeyShare oks=new OnekeyShare();
				oks.disableSSOWhenAuthorize();
				// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
				oks.setTitle("ssss");
				// titleUrl是标题的网络链接，仅在人人网和QQ空间使用
				oks.setTitleUrl("http://sharesdk.cn");
				// text是分享文本，所有平台都需要这个字段
				oks.setText("我是分享文本");
				// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
				oks.setImageUrl("http://wiki.mob.com/wp-content/uploads/2014/09/ssdk_qig_qi_win.png");
				// url仅在微信（包括好友和朋友圈）中使用
				oks.setUrl("http://sharesdk.cn");
				// comment是我对这条分享的评论，仅在人人网和QQ空间使用
				oks.setComment("我是测试评论文本");
				// site是分享此内容的网站名称，仅在QQ空间使用
				oks.setSite(getString(R.string.app_name));
				// siteUrl是分享此内容的网站地址，仅在QQ空间使用
				oks.setSiteUrl("http://sharesdk.cn");
				oks.setSilent(false);
				Bitmap enableLogo=BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
				Bitmap disableLogo=BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
				OnClickListener listener=new OnClickListener() {				
					public void onClick(View v) {
						Toast.makeText(MainActivity.this, "sss", 1).show();
					}
				};
				oks.setCustomerLogo(enableLogo, enableLogo, "ssd", listener);
//				oks.setShareContentCustomizeCallback(new ShareContentCustomizeCallback() {				
//					public void onShare(Platform platform, ShareParams paramsToShare) {
//						if (Wechat.NAME.equals(platform.getName())) {							
//								paramsToShare.setShareType(Platform.SHARE_FILE);
//								
//														
//						}
//					}
//				});
//				oks.setViewToShare(sinaWeiboBtn);
				oks.setCallback(new PlatformActionListener() {			
					@Override
					public void onError(Platform platform, int arg1, Throwable arg2) {
						// 分享/登录失败
					
						Log.i("tag", ""+arg2);
					}
					
					@Override
					public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
						// 分享/登录成功
						
					}
					
					@Override
					public void onCancel(Platform arg0, int arg1) {
						// 分享/登录取消
						
					}
				});
				
				oks.setDialogMode();
				oks.show(this);
				break;
			case R.id.sina_btn:
//				ShareParams sp=new ShareParams();
//				sp.setText("  ");
//				sp.setImageUrl("http://wiki.mob.com/wp-content/uploads/2014/09/ssdk_qig_qi_win.png");
//				Platform sina=ShareSDK.getPlatform(SinaWeibo.NAME);
//				sina.setPlatformActionListener(myLostener);
////				sina.showUser(null);
////				sina.SSOSetting(true);
//				sina.removeAccount();
//				ShareSDK.removeCookieOnAuthorize(true);
////				sina.followFriend("掌淘科技");
//				sina.share(sp);
//				Platform sina=ShareSDK.getPlatform(SinaWeibo.NAME);
//				if (sina.isAuthValid()) {
//					Toast.makeText(MainActivity.this, "sss", 1).show();
//				}
				break;
//				Shake2Share s2s = new Shake2Share();
//				// 设置回调，摇晃到一定程度就会触发分享
//				s2s.setOnShakeListener(new OnShakeListener() {
//					public void onShake() {
//						OnekeyShare oks = new OnekeyShare();
//						// 设置一个用于截屏分享的View
//						View windowView = getWindow().getDecorView();
//						oks.setViewToShare(windowView);
//						oks.setText("摇一摇，就分享");
//						 oks.setPlatform(SinaWeibo.NAME);
//						oks.show(MainActivity.this);
//					}
//	
//				});
//				// 启动“摇一摇分享”功能
//				s2s.show(MainActivity.this, null);
//				break;
				
			case R.id.sms_btn:
				Intent intent=new Intent();
				intent.setClass(this, two.class);
				startActivity(intent);
				break;
		}
	}

	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Platform weibo=ShareSDK.getPlatform(SinaWeibo.NAME);
		weibo.removeAccount();
		ShareSDK.removeCookieOnAuthorize(true);
		Log.i("tag", "onActivityResult");
	}

	
	class MyLostener implements PlatformActionListener{
		
		@Override
		public void onError(Platform arg0, int arg1, Throwable arg2) {
			Log.i("tag", "onError");
		}
		
		@Override
		public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
			// TODO Auto-generated method stub
			Log.i("tag", "onComplete");
			
			
		}
		
		@Override
		public void onCancel(Platform arg0, int arg1) {
			// TODO Auto-generated method stub
			Log.i("tag", "onCancel");
			
		}
		
	}
}
