# proguard-rules.pro for ScreenRecorder

# Retain the classes, methods, and fields for AndroidX libraries
-keep class androidx.** { *; }
-dontwarn androidx.**

# Keep Material Design components and prevent obfuscation
-keep class com.google.android.material.** { *; }
-dontwarn com.google.android.material.**

# Keep VideoTrimmer library classes and methods
-keep class com.gowtham.** { *; }
-dontwarn com.gowtham.**

# Keep classes with @Keep annotation (commonly used to prevent obfuscation)
-keep @androidx.annotation.Keep class * { *; }

# Retain Parcelable implementations to ensure correct functioning of intents
-keepclassmembers class * implements android.os.Parcelable {
    static final android.os.Parcelable$Creator CREATOR;
}

# Preserve serialized classes (Gson or other serializers)
-keepclassmembers class * {
    private static final long serialVersionUID;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# Keep methods annotated with @Keep or @JsonAdapter (if using Gson)
-keepclassmembers class * {
    @androidx.annotation.Keep *;
    @com.google.gson.annotations.JsonAdapter *;
}

# Retain the logging methods (e.g., for debugging)
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** w(...);
    public static *** v(...);
    public static *** i(...);
    public static *** e(...);
}

# Optimization directives
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

# Ensure all classes used by reflection are kept (for example in JSON serialization)
-keep class * {
    public static void main(java.lang.String[]);
}
-keepclassmembers class * {
    void *(...);
    <init>(...);
}

# Preserve main components to avoid issues with Activity, Service, BroadcastReceiver, and ContentProvider
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider

# Ensure correct operation of lambda expressions
-dontwarn java.lang.invoke.*

# Handle special cases where classes are dynamically loaded
-keep class * implements java.util.EventListener { *; }

# Keep attributes for debugging
-keepattributes Signature,SourceFile,LineNumberTable

# Obfuscation
-keepclassmembers class * {
    @androidx.annotation.Keep *;
}
