# MyTapSaver (Kotlin)

## 1) تثبيت Android Studio بسرعة
- نزّل Android Studio من الموقع الرسمي وثبّته (JDK مرفق).
- افتح Android Studio ثم `File > Open...` واختر مجلّد `MyTapSaver`.

## 2) فتح المشروع
- عند فتحه لأول مرة سيحمّل التبعيات تلقائياً.
- شغّل التطبيق عبر زر ▶️ واختر جهازًا افتراضيًا (AVD) أو هاتفك عبر USB.

## 3) التكوين المحلي (بدون إنترنت)
- يعمل التطبيق حفظًا محليًا تلقائيًا (`SharedPreferences`).

## 4) المزامنة مع Google/Firebase (اختياري لكن مضمّن في الكود)
1. اذهب إلى https://console.firebase.google.com وأنشئ مشروع Firebase جديد.
2. أضف تطبيق Android جديد: `applicationId = com.example.mytapsaver`.
3. حمّل ملف `google-services.json` وضعه هنا: `app/google-services.json`.
4. فعّل Authentication > Sign-in method > Google.
5. فعّل Firestore Database (وضع الإنتاج).
6. الآن يمكنك استدعاء دوال `FirebaseManager` من `MainActivity` بعد الحصول على `userId` من `FirebaseAuth`.

> ملاحظة: المشروع يحتوي اعتماد Firebase عبر BOM في `app/build.gradle`.

## 5) تخصيص النصوص
- راجع `app/src/main/res/values/strings.xml` لتغيير الكلمات (الهدف، المجموع، المتبقي).

## 6) حل مشكلات التحميل من ChatGPT
- إن لم تتمكن من تنزيل هذا الملف، افتح المحادثة في متصفح، عطّل الدردشة المؤقتة، وجرّب مجددًا.
- كحل بديل: انسخ الملفات من الرسالة في المحادثة يدويًا (طلبني وسأعرضها).

بالتوفيق!
