## Class SpeexCodex

speex音频编码解码。上传/下载至服务器的音频均为speex格式。

### 枚举类型
SpeexMode | 说明
--- | ---
SPEEX_NB_MODE | narrowband mode 适用于16位单声道8000Hz
SPEEX_WB_MODE | wideband mode 适用于16位单声道16000Hz

### 成员函数
函数名 | 作用
--- | ---
[decode](#XAudio::decode) | 解码
[encode](#XAudio::encode) | 编码

<a id="XAudio::decode"></a>
**decode**
DataBuffer \*decode(const DataBuffer& decodeSource, SpeexCodec::SpeexMode mode)
*参数*
decodeSource - 待解码speex格式数据
mode - SpeexMode
*返回*
解码完成pcm格式数据，需要手动释放返回数据

<a id="XAudio::encode"></a>
**encode**
DataBuffer \*encode(const DataBuffer& encodeSource, SpeexCodec::SpeexMode mode)
*参数*
decodeSource - 待编码pcm格式数据
mode - SpeexMode
*返回*
编码完成speex格式数据，需要手动释放返回数据



