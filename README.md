
# Facebook Video Downloader 
I'm going to show you another way to implement FB video downloader in Android Studio.

First if you did not watch [Papaya Coder's Facebook downloader video](https://www.youtube.com/watch?v=30q1fcIIhZg) then go and watch it. Then look at my method.



## Installation 

Add FacebookUrlExtractor library.

```bash 
 implementation 'com.github.Ashusolanki:FacebookUrlExtractor:0.0.1'
```
  
Add the JitPack repository
```bash
repositories {
    maven { url "https://jitpack.io" }
}
```
## Methods

```java
getAuthor();
getUrl();
getExt();
getFilename();
getQuality();
getDuration();
```

  
## Library I used
 - https://github.com/Ashusolanki/FacebookUrlExtractor


## Important Note
This method only works when you give following type of URL:
"https://www.facebook.com/102438284758534/videos/536904160301855"

That is
```
https://www.facebook.com/author or page name or id/videos/video id
```

If you want to contribute then do it!!

## Made with ❤️ by Abhay
