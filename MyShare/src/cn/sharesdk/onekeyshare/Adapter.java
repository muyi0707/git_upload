package cn.sharesdk.onekeyshare;

import android.view.ViewGroup.LayoutParams;
import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.authorize.AuthorizeAdapter;
import cn.sharesdk.tencent.qq.QQWebShareAdapter;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.tencent.qzone.QZoneWebShareAdapter;

public class Adapter extends AuthorizeAdapter{

	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		TitleLayout llTitle = getTitleLayout();
		llTitle.getTvTitle().setText("SB");
		
	}
}
