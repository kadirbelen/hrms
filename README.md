# İnsan kaynakları yönetim sistemi (Human resource management system)

  Proje katmanlı mimari ile oluşturulmuştur.
  ## Entities
  Entities katmanı projemizin veri tabanındaki her bir tabloya karşılık gelen varlıkları yazılmıştır.
  Bu katmanda özellikler kapsülleme yapılarak diğer katmanların erişimine izin verilmiştir.
  ## DataAccess
  DataAccess katmanı veri tabanına bağlandığımız katmandır.Bu katmanda sadece veri tabanına data ekleme,silme,güncelleme vb. işlemler gerçekleştirilir.
  **JpaRepository** kullanılarak işlemler gerçekleştirilmiştir.
  ##Business
  Business katmanında iş kuralları yazılmıştır.**Dependency injection** kullanılarak bağımlılıklarımızı olabildiğince azalttık.
  ## Api
  Api katmanı projemizin artık dış dünyaya açıldı katmandır.@GetMapping(),@PostMapping gibi işlemler kullanılarak kullanıcıya datayı gösterme veya kullanıcıdan data
  alma gibi işlemlerde gerçekleştirilmiştir.
  ## Core 
  Bu katman da tüm projelerimizde geçerliliğini koruyan classlar,interfaceler yer almıştır.
<br/>

Veritabanı isterleri

<br/>

Req 1 : İş Arayanlar sisteme kayıt olabilmelidir.

Kabul Kriterleri:

Kayıt sırasında kullanıcıdan ad, soyad, tcno, doğum yılı, e-Posta, şifre, şifre tekrarı bilgileri istenir.
Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
Mernis doğrulaması yapılarak sisteme kayıt gerçekleştirilir.
Doğrulama geçerli değilse kullanıcı bilgilendirilir.
Daha önce kayıtlı bir e-posta veya tcno var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.
Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir.
<br/>
Req 2 : İş verenler sisteme kayıt olabilmelidir.

Kabul Kriterleri:

Kayıt sırasında kullanıcıdan şirket adı, web sitesi, web sitesi ile aynı domaine sahip e-posta, telefon, şifre, şifre tekrarı bilgileri istenir. Burada amaç sisteme şirket olmayanların katılmasını engellemektir.
Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
Şirket kayıtları iki şekilde doğrulanır. Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir. HRMS personelinin (bizim :)) onayı gerekmektedir.
Daha önce kayıtlı bir e-posta var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.
<br/>
Req 3 : Sisteme genel iş pozisyonu isimleri eklenebilmelidir. Örneğin Software Developer, Software Architect.

Kabul Kriterleri:

Bu pozisyonlar tekrar edemez. Kullanıcı uyarılır.
<br/><br/><br/>
#Spring Boot ile isterler yerine getirildi
<br/>
Req 1 : İş Arayanlar sisteme kayıt olabilmelidir.
<br/>
Kabul Kriterleri:

Kayıt sırasında kullanıcıdan ad, soyad, tcno, doğum yılı, e-Posta, şifre, şifre tekrarı bilgileri istenir.
Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
Mernis doğrulaması yapılarak sisteme kayıt gerçekleştirilir.
Doğrulama geçerli değilse kullanıcı bilgilendirilir.
Daha önce kayıtlı bir e-posta veya tcno var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.
Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir.<br/>
Req 2 : İş verenler sisteme kayıt olabilmelidir.<br/>

Kabul Kriterleri:

Kayıt sırasında kullanıcıdan şirket adı, web sitesi, web sitesi ile aynı domaine sahip e-posta, telefon, şifre, şifre tekrarı bilgileri istenir. Burada amaç sisteme şirket olmayanların katılmasını engellemektir.
Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
Şirket kayıtları iki şekilde doğrulanır. Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir. HRMS personelinin (bizim :)) onayı gerekmektedir.
Daha önce kayıtlı bir e-posta var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.<br/>
Req 3 : Sisteme genel iş pozisyonu isimleri eklenebilmelidir. Örneğin Software Developer, Software Architect.<br/>

Kabul Kriterleri:

Bu pozisyonlar tekrar edemez. Kullanıcı uyarılır.<br/>
Req 4 : İş verenler listelenebilmelidir. (Sadece tüm liste)<br/>

Req 5 : İş arayanlar listelenebilmelidir. (Sadece tüm liste)<br/>

Req 6 : İş pozisyonları listelenebilmelidir. (Sadece tüm liste)<br/>

<br/><br/>
#İş verenler sisteme iş ilanı ekleyebilir<br/>
Req 7 : İş verenler sisteme iş ilanı ekleyebilmelidir.

İş ilanı formunda;
Seçilebilir listeden (dropdown) genel iş pozisyonu seçilebilmelidir.(Örneğin Java Developer)(Zorunlu)
İş tanımı girişi yapılabilmelidir. (Örneğin; firmamız için JAVA, C# vb. dillere hakim....)(Zorunlu)
Şehir bilgisi açılır listeden seçilebilmelidir. (Zorunlu)
Maaş skalası için min-max girişi yapılabilmelidir. (Opsiyonel)
Açık pozisyon adedi girişi yapılabilmelidir. (Zorunlu)
Son başvuru tarihi girişi yapılabilmelidir.<br/>
Req 8 : Sistemdeki tüm aktif iş ilanları listelenebilmelidir.

Liste, tablo formunda gelmelidir.
Listede firmadı, genel iş pozisyonu adı, açık pozisyon adedi, yayın tarihi, son başvuru tarihi bilgileri olmalıdır.<br/>
Req 9 : Sistemdeki tüm aktif iş ilanları tarihe göre listelenebilmelidir.

Liste, tablo formunda gelmelidir.
Listede firmadı, genel iş pozisyonu adı, açık pozisyon adedi, yayın tarihi, son başvuru tarihi bilgileri olmalıdır.<br/>
Req 10 : Sistemde bir firmaya ait tüm aktif iş ilanları listelenebilmelidir.

Liste, tablo formunda gelmelidir.
Listede firmadı, genel iş pozisyonu adı, açık pozisyon adedi, yayın tarihi, son başvuru tarihi bilgileri olmalıdır.<br/>
Req 11 : İş verenler sistemdeki bir ilanı kapatabilmelidir. (Pasif ilan)

