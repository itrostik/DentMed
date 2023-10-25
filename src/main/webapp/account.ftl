<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Аккаунт</title>
  <link rel="stylesheet" href="./css/style.css">
  <link rel="stylesheet" href="./css/account.css">
</head>
<body>
<div class="wrapper">
    <#include "header.ftl">
  <main class="main __container">
    <div class="main__info">
      <div class="main__title">Информация об аккаунте</div>
      <div class="main__name">
        <span>Имя</span>
        <span>${user.firstName + " " + user.lastName}</span>
      </div>
      <div class="main__login">
        <span>Логин</span>
        <span>${user.login}</span>
      </div>
      <div class="main__number">
        <span>Номер телефона</span>
        <span>${user.phoneNumber}</span>
      </div>
      <div class="main__name">
        <span>Адрес</span>
        <span>${user.address}</span>
      </div>
      <div class="main__email">
        <span>Почта</span>
        <span>${user.email}</span>
      </div>
    </div>
  </main>
    <#include "footer.ftl">
</div>
</body>
</html>