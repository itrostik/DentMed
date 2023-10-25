<header class="header">
  <div class="header__top">
    <div class="header__container __container">
      <div class="header__logo">
        <img src="./img/logo.svg" alt="logo">
      </div>
      <div class="header__text">
        <div>Стоматологическая клиника в Казани</div>
      </div>
      <div class="header__location">
        <img src="./img/place-indicator.svg" alt="place-indicator">
        <div class="header__location-text">
          <div>Казань</div>
          <div>с 8:00 до 20:00</div>
        </div>
      </div>
      <div class="header__call">
        <img src="./img/telephone.svg" alt="">
        <div class="header__call-info">
          <div class="header__call-number">+7 (915) 690 43 43</div>
          <div class="header__call-text">Звоните по любым вопросам</div>
        </div>
      </div>
    </div>
  </div>
  <div class="header__bottom">
    <div class="header__container __container">
      <div class="header__menu">
        <ul class="header__list">
          <li class="header__list-item">
              <#if user??>
                <a href="/user">Главная</a>
              <#else>
                <a href="/index.ftl">Главная</a>
              </#if>
          </li>
          <li class="header__list-item">
              <#if user??>
                <a href="/doctors">Наши специалисты</a>
              <#else>
                <a href="/doctors">Наши специалисты</a>
              </#if>
          </li>
          <li class="header__list-item">
              <#if user??>
                <a href="/services">Услуги</a>
              <#else>
                <a href="/services.ftl">Услуги</a>
              </#if>
          </li>
          <li class="header__list-item">
              <#if user??>
                <a href="/posts">Посты</a>
              <#else>
                <a href="/posts">Посты</a>
              </#if>
          </li>
          <li class="header__list-item">
              <#if user??>
                <a href="/forum">Форум</a>
              <#else>
                <a href="/forum">Форум</a>
              </#if>
          </li>
        </ul>
      </div>
        <#if user??>
          <a href="/account" class="user__login">${user.firstName + " " + user.lastName}</a>
          <a href="/logout" class="user__logout">Выйти из аккаунта</a>
        <#else>
          <a href="/login" class="header__enter">
            Вход
          </a>
          <a href="/registration" class="header__register">Регистрация</a>
        </#if>
    </div>
  </div>
</header>
