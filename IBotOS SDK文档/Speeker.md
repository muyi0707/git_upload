## Class XiaoiSpeeker

 将文字转化为语音并播出。XiaoiSpeeker继承自Speeker。
 
### 基类成员函数
函数名 | 作用
--- | ---
[say](#Speeker::say) | 将文字转化为语音并播出
[stopSay](#Speeker::stopSay) | 停止播放语音
[isSaying](#Speeker::isSaying) | 是否正在播放语音

<a id="Speeker::say"></a>
**Speeker::say**
bool say(const std::string& word)
*参数*
word - 需要播出的文字
*返回*
从服务器正确获得音频文件并播出时返回true
无法从服务器获得音频文件、无法播放音频时返回false

<a id="Speeker::stopSay"></a>
**Speeker::stopSay**
void stopSay()
停止播放语音

<a id="Speeker::isSaying"></a>
**Speeker::isSaying**
bool isSaying()
*返回*
语音正在播放时返回true
语音停止播放时返回false

### 示例
```c++
XiaoiSpeaker speaker;
speaker.say("你好");
```


