<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>ДентМед</title>
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
  <main class="main__container __container">
    <div class="main__services">
      <div class="main__services-text">
        <div class="main__services-title">Наши услуги</div>
        <div class="main__services-paragraph">Стоматологическая клиника для всей семьи. У нас можно получить
          бесплатную консультацию дистанционно или записаться на приём. Возможен выезд лечащего врача на дом к лежачим
          больным. Врачи с опытом работы более 10 лет. Новейшее оборудование и новые технологии в лечении зубов и
          полости рта.
        </div>
      </div>
      <div class="main__services-image">
        <img src="./img/registry.jpeg" alt="">
      </div>
      <div class="main__services-info">
        <div class="main__services-block">
          <div class="services-block-item">
            <span class="services-block-title">Протезирование</span>
            <div class="services-block-icon">
              <img src="./img/icons_plus.svg" alt="">
            </div>
          </div>
          <div class="services-block-description">
            <div class="services-block-text">
              <span>Протезирование - это процесс замены отсутствующих зубов с помощью искусственных протезов. Наша команда специалистов предлагает различные виды протезов, включая съемные и фиксированные протезы, которые максимально приближены к естественному виду зубов. Протезирование помогает восстановить функциональность рта, улучшить жевательную функцию и вернуть уверенность в улыбке.</span>
              <#if user??>
                <div class="services-block-button modal__openButton">Запись онлайн</div>
              <#else>
                <a href="/login" class="services-block-button" style="color: #FFFFFF;">Запись онлайн</a>
              </#if>
            </div>
            <div class="services-block-image">
              <img src="./img/toothache.png" alt="">
            </div>
          </div>
        </div>
        <div class="main__services-block">
          <div class="services-block-item">
            <span class="services-block-title">Ортодонтия (брекеты)</span>
            <div class="services-block-icon">
              <img src="./img/icons_plus.svg" alt="">
            </div>
          </div>
          <div class="services-block-description">
            <div class="services-block-text">
              <span>Ортодонтия с использованием брекет-систем - это эффективный способ исправления неправильного прикуса и выравнивания зубов. Наши опытные ортодонты помогут подобрать наиболее подходящую систему брекетов для вашего случая, которая будет работать неприметно и обеспечит оптимальные результаты. Ортодонтическое лечение с брекетами позволяет достичь не только красивой улыбки, но и улучшить здоровье полости рта.</span>
                <#if user??>
                  <div class="services-block-button modal__openButton">Запись онлайн</div>
                <#else>
                  <a href="/login" class="services-block-button" style="color: #FFFFFF;">Запись онлайн</a>
                </#if>
            </div>
            <div class="services-block-image">
              <img src="./img/toothache.png" alt="">
            </div>
          </div>
        </div>
        <div class="main__services-block">
          <div class="services-block-item">
            <span class="services-block-title">Виниры и люминиры</span>
            <div class="services-block-icon">
              <img src="./img/icons_plus.svg" alt="">
            </div>
          </div>
          <div class="services-block-description">
            <div class="services-block-text">
              <span>Виниры и люминиры - это тонкие керамические накладки, которые наклеиваются на переднюю поверхность зубов, чтобы улучшить их внешний вид. Эта процедура позволяет скорректировать форму, цвет и выравнивание зубов, создавая идеальную улыбку. Виниры и люминиры являются долговременным решением для тех, кто хочет иметь прекрасную улыбку без сложных и долгих процедур.</span>
                <#if user??>
                  <div class="services-block-button modal__openButton">Запись онлайн</div>
                <#else>
                  <a href="/login" class="services-block-button" style="color: #FFFFFF;">Запись онлайн</a>
                </#if>
            </div>
            <div class="services-block-image">
              <img src="./img/toothache.png" alt="">
            </div>
          </div>
        </div>
        <div class="main__services-block">
          <div class="services-block-item">
            <span class="services-block-title">Чистка и отбеливание</span>
            <div class="services-block-icon">
              <img src="./img/icons_plus.svg" alt="">
            </div>
          </div>
          <div class="services-block-description">
            <div class="services-block-text">
              <span>Чистка и отбеливание зубов - это процедуры, которые помогают сохранить здоровье и красоту вашей улыбки. Наша команда гигиенистов предлагает профессиональную чистку зубов, которая удаляет налет и зубной камень, а также полировку, чтобы ваши зубы стали гладкими и блестящими. Отбеливание зубов - это безопасная и эффективная процедура, которая позволяет осветлить зубы на несколько оттенков, восстанавливая их естественную белизну.</span>
                <#if user??>
                  <div class="services-block-button modal__openButton">Запись онлайн</div>
                <#else>
                  <a href="/login" class="services-block-button" style="color: #FFFFFF;">Запись онлайн</a>
                </#if>
            </div>
            <div class="services-block-image">
              <img src="./img/dental-treatment.png" alt="">
            </div>
          </div>
        </div>
        <div class="main__services-block">
          <div class="services-block-item">
            <span class="services-block-title">Реставрация и восстановление</span>
            <div class="services-block-icon">
              <img src="./img/icons_plus.svg" alt="">
            </div>
          </div>
          <div class="services-block-description">
            <div class="services-block-text">
              <span>Реставрация и восстановление зубов - это процедуры, направленные на восстановление поврежденных или поврежденных зубов. Наша команда стоматологов предлагает различные методы реставрации, включая пломбирование, коронки и мосты, которые восстанавливают форму, функцию и эстетику зубов. Реставрация и восстановление помогают сохранить здоровье зубов и предотвратить дальнейшее разрушение.</span>
                <#if user??>
                  <div class="services-block-button modal__openButton">Запись онлайн</div>
                <#else>
                  <a href="/login" class="services-block-button" style="color: #FFFFFF;">Запись онлайн</a>
                </#if>
            </div>
            <div class="services-block-image">
              <img src="./img/toothache.png" alt="">
            </div>
          </div>
        </div>
        <div class="main__services-block">
          <div class="services-block-item">
            <span class="services-block-title">Удаление зубов</span>
            <div class="services-block-icon">
              <img src="./img/icons_plus.svg" alt="">
            </div>
          </div>
          <div class="services-block-description">
            <div class="services-block-text">
              <span>Удаление зубов - это процедура, которая проводится в случае необходимости удаления поврежденных, больных или мудреных зубов. Наша команда стоматологов обеспечит максимально комфортное и безопасное удаление зуба с использованием современных методов и обезболивающих средств. После удаления зуба мы также предлагаем различные методы замены потерянного зуба, чтобы восстановить функциональность рта и эстетику улыбки.</span>
                <#if user??>
                  <div class="services-block-button modal__openButton">Запись онлайн</div>
                <#else>
                  <a href="/login" class="services-block-button" style="color: #FFFFFF;">Запись онлайн</a>
                </#if>
            </div>
            <div class="services-block-image">
              <img src="./img/toothache.png" alt="">
            </div>
          </div>
        </div>
        <div class="main__services-block">
          <div class="services-block-item">
            <span class="services-block-title">Имплантация</span>
            <div class="services-block-icon">
              <img src="./img/icons_plus.svg" alt="">
            </div>
          </div>
          <div class="services-block-description">
            <div class="services-block-text">
              <span>Имплантация - это инновационная процедура восстановления потерянных зубов путем вживления искусственных корней зубов в костную ткань челюсти. Наша команда имплантологов предлагает высококачественные импланты, которые обеспечивают надежную фиксацию протезов и долговечность. Имплантация зубов позволяет вернуть уверенность в улыбке, восстановить функциональность рта и предотвратить дальнейшее разрушение зубов.</span>
                <#if user??>
                  <div class="services-block-button modal__openButton">Запись онлайн</div>
                <#else>
                  <a href="/login" class="services-block-button" style="color: #FFFFFF;">Запись онлайн</a>
                </#if>
            </div>
            <div class="services-block-image">
              <img src="./img/dental-treatment.png" alt="">
            </div>
          </div>
        </div>
        <div class="main__services-block">
          <div class="services-block-item">
            <span class="services-block-title">Лечение во сне</span>
            <div class="services-block-icon">
              <img src="./img/icons_plus.svg" alt="">
            </div>
          </div>
          <div class="services-block-description">
            <div class="services-block-text">
              <span>Лечение во сне - это инновационный метод, который позволяет проводить стоматологические процедуры безболезненно и без стресса для пациента. Наша команда специалистов предлагает лечение во сне с использованием седации, что позволяет пациенту оставаться расслабленным и спокойным во время лечения. Этот метод особенно полезен для людей с фобией перед стоматологическими процедурами или для детей, которые не могут сотрудничать во время лечения.</span>
                <#if user??>
                  <div class="services-block-button modal__openButton">Запись онлайн</div>
                <#else>
                  <a href="/login" class="services-block-button" style="color: #FFFFFF;">Запись онлайн</a>
                </#if>
            </div>
            <div class="services-block-image">
              <img src="./img/toothache.png" alt="">
            </div>
          </div>
        </div>
        <div class="main__services-block">
          <div class="services-block-item">
            <span class="services-block-title">Лечение зубов и десен</span>
            <div class="services-block-icon">
              <img src="./img/icons_plus.svg" alt="">
            </div>
          </div>
          <div class="services-block-description">
            <div class="services-block-text">
              <span>Лечение зубов и десен - это комплексный подход к восстановлению и улучшению здоровья полости рта. Наша команда стоматологов предлагает широкий спектр услуг, включая лечение кариеса, лечение зубного камня, лечение заболеваний десен и других проблем. Мы используем современные методы и технологии, чтобы обеспечить эффективное и безболезненное лечение, восстанавливающее здоровье и красоту вашей улыбки.</span>
                <#if user??>
                  <div class="services-block-button modal__openButton">Запись онлайн</div>
                <#else>
                  <a href="/login" class="services-block-button" style="color: #FFFFFF;">Запись онлайн</a>
                </#if>
            </div>
            <div class="services-block-image">
              <img src="./img/dental-treatment.png" alt="">
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="main__price">
      <div class="main__price-title">Стоимость популярных услуг</div>
      <div class="main__price-info">
        <div class="main__price-block">
          <span class="price-block__name">Консультация и осмотр</span>
          <span class="price-block__count">Беcплатно</span>
        </div>
        <div class="main__price-block">
          <span class="price-block__name">Лечение одноканального зуба</span>
          <span class="price-block__count">От 2000 ₽</span>
        </div>
        <div class="main__price-block">
          <span class="price-block__name">Лечение двухканального зуба</span>
          <span class="price-block__count">От 2 500 ₽</span>
        </div>
        <div class="main__price-block">
          <span class="price-block__name">Лечение трёхканального зуба</span>
          <span class="price-block__count">От 3 000 ₽</span>
        </div>
        <div class="main__price-block">
          <span class="price-block__name">Удаление зуба</span>
          <span class="price-block__count">От 800 ₽</span>
        </div>
        <div class="main__price-block">
          <span class="price-block__name">Керамические коронки</span>
          <span class="price-block__count">От 5 500 ₽</span>
        </div>
        <div class="main__price-block">
          <span class="price-block__name">Брекет-система</span>
          <span class="price-block__count">От 20 000 ₽</span>
        </div>
        <div class="main__price-block">
          <span class="price-block__name">Металлокерамика</span>
          <span class="price-block__count">От 12 000 ₽</span>
        </div>
      </div>
    </div>
  </main>
    <#include "footer.ftl">
</div>
<script src="js/main.js"></script>
</body>
</html>