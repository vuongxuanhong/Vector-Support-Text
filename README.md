# Vector-Support-Text
TextView and EditText will support vector image for compound drawable, also provide customize size of compound drawable

Screenshot:

![screen_shot][logo]

# Install

<b>Step 1. Add the JitPack repository to your build file. </b>

Add it in your root build.gradle at the end of repositories

```code
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

<b>Step 2. Add the dependency</b>

```java
	dependencies {
	        implementation 'com.github.vuongxuanhong:Vector-Support-Text:1.0'
	}
```

# Usage

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <com.alex.vectorsupportlib.VectorSupportTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:text="Hello World!"
        app:drawableBottomCompat="@drawable/ic_favorite_red_24dp"
        app:drawableBottomSquareSize="48dp"
        app:drawableEndCompat="@drawable/ic_favorite_red_24dp"
        app:drawableEndSquareSize="24dp"
        app:drawableStartCompat="@drawable/ic_favorite_red_24dp"
        app:drawableStartSquareSize="16dp"
        app:drawableTopCompat="@drawable/ic_favorite_red_24dp"
        app:drawableTopSquareSize="32dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```

[logo]: https://github.com/vuongxuanhong/Vector-Support-Text/blob/master/app/screenshot/Screen%20Shot%202018-09-04%20at%206.01.49%20PM.png "Screenshot"
