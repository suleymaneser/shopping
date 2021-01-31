<template>
  <Product/>
  <Customer/>
</template>

<script>
import Product from './components/Product.vue'
import Customer from './components/Customer.vue'

export default {
  name: 'App',
  components: {
    Product,
    Customer
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  background-color: #f6f6f6;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
