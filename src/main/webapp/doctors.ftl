<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
  <link rel="stylesheet" href="./css/style.css">
  <link rel="stylesheet" href="./css/doctors.css">
  <link
          rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css"
  />
</head>
<body>
<div class="wrapper">
    <#include "header.ftl">
  <main class="main">
    <div class="__container">
      <div class="doctors__text">
        <h1>Квалифицированные стоматологи</h1>
        <h3>Помогут сохранить и вернуть здоровье вашим зубам</h3>
      </div>
    </div>
    <!-- Slider main container -->
    <div class="__container">
      <div class="swiperDoctors">
        <!-- Additional required wrapper -->
        <div class="swiper-wrapper">
          <!-- Slides -->
            <#list doctors as doctor>
              <div class="swiper-slide doctor">
                <div class="doctor__image">
                  <img src="./img/doctor${doctor.doctorId}.jpeg" alt="">
                </div>
                <div class="doctor__name">${doctor.name}</div>
              </div>
            </#list>
        </div>
        <div class="swiper-button-prev"></div>
        <div class="swiper-button-next"></div>
      </div>
    </div>
    <div class="doctorInfo__block">
      <div class="doctorInfo__image">
        <img src="" alt="">
      </div>
      <div class="doctorInfo__info">
        <div class="doctorInfo__name"></div>
        <div class="doctorInfo__special"></div>
        <div class="doctorInfo__ageWork"></div>
        <div class="doctorInfo__description"></div>
        <form action="/doctor" method="get" style="display: none">
          <input type="text" name="doctorId" value="" style="display: none">
          <button type="submit" class="doctor__button">Посмотреть отзывы</button>
        </form>
      </div>
    </div>
  </main>
    <#include "footer.ftl">
</div>
<script src="js/main.js"></script>
<script type="module" src="js/swiperDoctors.js"></script>
<script type="module" src="js/doctors.js"></script>
</body>
</html>