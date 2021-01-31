<template>
  <div class="jumbotron text-center">
    <h1>Hoşgeldiniz</h1>
    <p>Ürünler ve müşteri bilgileri için ilgili sayfaya menüden geçebilirsiniz.</p>
  </div>

    <h2 style="text-align:center">Servislerimiz</h2>
    <div class="row">
      <div class="column">
        <div class="card">
          <img src="../assets/user.jpg" alt="Müşteri" style="width:100%">
          <div class="container">
            <h2>Müşteri</h2>
            <p class="title">Shoppingin merkezi servislerinden.</p>
            <p>customer@example.com</p>
            <p><button class="button">Üye Ol</button></p>
          </div>
        </div>
      </div>

      <div class="column">
        <div class="card">
          <img src="../assets/product.jpg" alt="Ürün" style="width:100%">
          <div class="container">
            <h2>Ürün</h2>
            <p class="title">Shoppingin merkezi servislerinden.</p>
            <p>product@example.com</p>
            <p><button class="button">Ürün Ekle</button></p>
          </div>
        </div>
      </div>

      <div class="column">
        <div class="card">
          <img src="../assets/market.jpg" alt="Pazar" style="width:75%">
          <div class="container">
            <h2>Pazar</h2>
            <p class="title">Shoppingin merkezi servislerinden.</p>
            <p>market@example.com</p>
            <p><button class="button">Ürün Ara</button></p>
          </div>
        </div>
      </div>
    </div>
</template>

<style>
  body {
    font-family: Arial, Helvetica, sans-serif;
    margin: 0;
  }

  html {
    box-sizing: border-box;
  }

  *, *:before, *:after {
    box-sizing: inherit;
  }

  .column {
    float: left;
    width: 30%;
    margin-bottom: 16px;
    padding: 0 8px;
  }

  .card {
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
    margin: 8px;
  }

  .about-section {
    padding: 50px;
    text-align: center;
    background-color: #474e5d;
    color: white;
  }

  .container {
    padding: 0 16px;
  }

  .container::after, .row::after {
    content: "";
    clear: both;
    display: table;
  }

  .title {
    color: grey;
  }

  .button {
    border: none;
    outline: 0;
    display: inline-block;
    padding: 8px;
    color: white;
    background-color: #000;
    text-align: center;
    cursor: pointer;
    width: 100%;
  }

  .button:hover {
    background-color: #555;
  }

  @media screen and (max-width: 650px) {
    .column {
      width: 100%;
      display: block;
    }
  }
</style>


