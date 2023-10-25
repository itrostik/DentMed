<footer class="footer">
  <div class="footer__container __container">
    <div class="footer__top">
      <div class="footer__top-block">
        <div class="footer__logo">
          <img src="./img/footer-logo.svg" alt="">
        </div>
        <div class="footer__logo-text">Ваша улыбка - наша забота</div>
      </div>
      <div class="footer__top-block">
        <ul class="footer__top-menu">
          <li class="footer__top-item item-title">О нас</li>
          <li class="footer__top-item">
              <#if user??>
                <a href="/services">Наши услуги</a>
              <#else>
                <a href="services.ftl">Наши услуги</a>
              </#if>
          </li>
          <li class="footer__top-item">
            <a href="/doctors">Наши специалисты</a>
          </li>
        </ul>
      </div>
      <div class="footer__top-block">
        <ul class="footer__top-menu">
          <li class="footer__top-item item-title">Информация</li>
          <li class="footer__top-item">
            <a href="/posts">Посты</a>
          </li>
          <li class="footer__top-item">
            <a href="/forum">Форум</a>
          </li>
        </ul>
      </div>
      <div class="footer__top-block">
        <div class="footer__top-item item-title">Связаться с нами</div>
        <div class="footer__top-info">
          <div class="footer__top-call footer__info-block">
            <img src="./img/footer-call.svg" alt="">
            <span>+7 (915) 690 43 43</span>
          </div>
          <div class="footer__top-whatsapp footer__info-block">
            <img src="./img/whatsapp.svg" alt="">
            <span>+7 (915) 690 43 43</span>
          </div>
          <div class="footer__top-mail footer__info-block">
            <img src="./img/mail.svg" alt="">
            <span>dentomed@gmail.com</span>
          </div>
        </div>
      </div>
    </div>
    <div class="footer__bottom">
      <div class="footer__bottom-license">
        2052 © Все права защищены
      </div>
      <div class="footer__bottom-social">
        <a href="#"><img src="./img/icon-vk.svg" alt=""></a>
        <a href="#"><img src="./img/facebook-icon.svg" alt=""></a>
        <a href="#"><img src="./img/insta-icon.svg" alt=""></a>
      </div>
    </div>
  </div>
</footer>