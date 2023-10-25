<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>ДентМед</title>
  <link rel="stylesheet" href="./css/style.css">
  <link rel="stylesheet" href="./css/posts.css">
</head>
<body>
<div class="wrapper">
    <#include "header.ftl">
  <main class="main __container">
      <#if user??>
        <a href="/addPost" class="posts__addButton" style="color: #ffffff">
          Добавить пост
        </a>
      <#else>
        <a href="/login" class="posts__addButton" style="color: #ffffff">Добавить пост</a>
      </#if>
    <#if posts??>
      <div class="posts">
          <#list users as elem>
              <#list posts as item>
                  <#if elem.userId == item.authorId>
                    <div class="post">
                        <#if user??>
                            <#if user.userId == item.authorId>
                              <form action="/deletePost">
                                <input type="text" name="postId" value="${item.postId}" style="display: none">
                                <button type="submit" class="post__delete">
                                  <img src="./img/multiply.svg" alt="">
                                </button>
                              </form>
                            </#if>
                        </#if>
                      <div class="post__title">${item.title}</div>
                      <div class="post__content">${item.content}</div>
                      <form action="/post" method="get">
                        <input type="text" name="postId" value="${item.postId}" style="display: none"/>
                        <button type="submit" class="post__button" style="color: #ffffff">Посмотреть комментарии</button>
                      </form>
                      <div class="post__info">
                        <div class="post__date">${item.date}</div>
                        <div class="post__authorId">${elem.firstName + " " + elem.lastName}</div>
                      </div>
                    </div>
                  </#if>
              </#list>
          </#list>
      </div>
      <#else>
        <div>Постов нет</div>
    </#if>
  </main>
    <#include "footer.ftl">
</div>
<script src="js/main.js"></script>
</body>
</html>