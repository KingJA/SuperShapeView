# SuperShapeView
A smart custom view support shapes for TextView ,EditView ,ImageView and so on,instead of shape.xml. CLICK THE ***STAR***  if it's useful for you.

## Preview
<div align="center"><img src="imgs/super_shape_view.png"/></div>

## Custom attribute
| attribute | format | example  |
| :------------- |:-------------| :-----|
| super_cornerRadius | dimension      | app:super_cornerRadius="5dp" |
| super_strokeWidth | dimension      | app:super_strokeWidth="1dp" |
| super_strokeColor | color/reference       | app:super_strokeColor="#bebebe" |
| super_solidColor | color/reference     | app:super_solidColor="@color/red" |
| super_dashWidth | dimension     | app:super_dashWidth="2dp" |
| super_dashGap | dimension     | app:super_dashGap="2dp" |
| super_topLeftRadius | dimension     | app:super_topLeftRadius="2dp" |
| super_topRightRadius | dimension     | app:super_topRightRadius="2dp" |
| super_bottomLeftRadius | dimension     | app:super_bottomLeftRadius="2dp" |
| super_bottomRightRadius | dimension     | app:super_bottomRightRadius="2dp" |

## Gradle
```java
 compile 'com.kingja.supershapeview:supershapeview:1.2.0'
```

## Usage
##### in xml
* Image
```xml
<com.kingja.supershapeview.view.SuperShapeImageView
    android:id="@+id/ssiv"
    android:layout_width="100dp"
    android:layout_height="100dp"
    android:layout_marginLeft="12dp"
    android:layout_marginRight="12dp"
    android:onClick="changeIvStyle"
    android:scaleType="centerCrop"
    android:src="@mipmap/taylor"
    app:super_cornerRadius="50dp"
    app:super_strokeColor="#000000"
    app:super_strokeWidth="2dp"/>
```
* others
```xml
<com.kingja.supershapeview.view.SuperShapeTextView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:gravity="center"
    android:padding="12dp"
    android:text="更多"
    android:textColor="#d2490e"
    app:super_dashGap="2dp"
    app:super_dashWidth="2dp"
    app:super_solidColor="#ffffff"
    app:super_strokeColor="#d2490e"
    app:super_strokeWidth="1dp"/>
```

##### modify attrs dynamically
```java
SuperShapeTextView superShapeTextView = (SuperShapeTextView) view;
SuperManager superManager = superShapeTextView.getSuperManager();
superManager.setSolidColor(0xff303F9F);
superManager.setStrokeColor(getResources().getColor(R.color.colorAccent));
superManager.setCorner(20);//DP
superManager.setStrokeWidth(2);//DP
superManager.setDashGap(2);//DP
superManager.setDashWidth(2);//DP
superManager.setCorner(10,6,10,6);
...
```

## Changelog
**v1.2.0**
- add API for setting attrs
- add ImageView Shape (SuperShapeImageView)

**v1.1.1**
- Initial release 

## Contact me
Any questions:Welcome to contact me.
* Email:kingjavip@gmail.com

## License

    Copyright 2017 KingJA

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
