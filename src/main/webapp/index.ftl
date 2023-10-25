<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>ДентМед</title>
  <link
          rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css"
  />
  <link rel="stylesheet" href="./css/style.css">
</head>
<body>

<#if user??>
  <div class="modal">
    <div class="modal__content">
      <h1 class="modal__content-title">Уважаемый(ая) ${user.firstName + " " + user.lastName}</h1>
      <span class="modal__content-text">Вам скоро позвонят для уточнения информации, ожидайте</span>
      <div class="сlose__modal">Закрыть окно</div>
    </div>
  </div>
</#if>

<div class="wrapper">
    <#include "header.ftl">
  <main class="main">
    <div class="swiper">
      <!-- Additional required wrapper -->
      <div class="swiper-wrapper">
        <!-- Slides -->
        <div class="swiper-slide">
          <div class="swiper-slide__container">
            <div class="swiper-slide__info">
              <div class="swiper-slide__title">
                Имплантация зубов
              </div>
              <div class="swiper-slide__text">
                Современный метод восстановления потерянных зубов, который позволяет вернуть уверенность в своей улыбке.
              </div>
                <#if user??>
                  <div class="swiper-slide__button modal__openButton">Записаться на приём</div>
                <#else>
                  <a href="/login" class="swiper-slide__button">Записаться на приём</a>
                </#if>
            </div>
            <div class="swiper-slide__image">
              <img src="./img/Имплантация.jpg" alt="">
            </div>
          </div>
        </div>
        <div class="swiper-slide">
          <div class="swiper-slide__container">
            <div class="swiper-slide__info">
              <div class="swiper-slide__title">
                Ортодонтическое лечение
              </div>
              <div class="swiper-slide__text">
                Комплекс мероприятий, направленных на исправление неправильного прикуса и выравнивание зубов.
              </div>
                <#if user??>
                  <div class="swiper-slide__button modal__openButton">Записаться на приём</div>
                <#else>
                  <a href="/login" class="swiper-slide__button">Записаться на приём</a>
                </#if>
            </div>
            <div class="swiper-slide__image">
              <img src="./img/ортопед.jpg" alt="">
            </div>
          </div>
        </div>
        <div class="swiper-slide">
          <div class="swiper-slide__container">
            <div class="swiper-slide__info">
              <div class="swiper-slide__title">
                Комплексная профгигиена
              </div>
              <div class="swiper-slide__text">
                Подразумевает проведение ряда процедур, помогающих очистить зубы и десны от постоянно накапливающегося
                мягкого налета и твердого зубного камня.
              </div>
                <#if user??>
                  <div class="swiper-slide__button modal__openButton">Записаться на приём</div>
                <#else>
                  <a href="/login" class="swiper-slide__button">Записаться на приём</a>
                </#if>
            </div>
            <div class="swiper-slide__image">
              <img src="./img/Профгигиена.png" alt="">
            </div>
          </div>
        </div>
      </div>
      <div class="swiper-pagination"></div>
      <!-- If we need navigation buttons -->
      <div class="swiper-button-prev"></div>
      <div class="swiper-button-next"></div>
    </div>
    <div class="main__container __container">
      <div class="main__economic">
        <div class="main__economic-title">Мы экономим ваши деньги</div>
        <div class="main__economic-info">
          <div class="main__economic-block">
            <div class="economic-block__image">
              <img src="./img/Калькулятор.svg" alt="">
            </div>
            <div class="economic-block__title">Стоимость фиксирована</div>
            <div class="economic-block__text">Окончательную цену узнаете на консультации. Любые изменения будут
              обсуждены с вами.
            </div>
          </div>
          <div class="main__economic-block">
            <div class="economic-block__image">
              <img src="./img/Блокнот.svg" alt="">
            </div>
            <div class="economic-block__title">Без лишних услуг</div>
            <div class="economic-block__text">В стоимость входят лечение, материалы, все необходимые затраты</div>
          </div>
          <div class="main__economic-block">
            <div class="economic-block__image">
              <img src="./img/Договор.svg" alt="">
            </div>
            <div class="economic-block__title">Договор оказания услуг</div>
            <div class="economic-block__text">Фиксируем собственную ответственность и обязательства</div>
          </div>
        </div>
      </div>
    </div>
  </main>
    <#include "footer.ftl">
</div>
<script type="module" src="js/swiper.js"></script>
<script src="js/main.js"></script>
</body>
</html>