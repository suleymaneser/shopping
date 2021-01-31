import { createRouter, createWebHistory } from 'vue-router'
import Product from '../components/Product.vue'
import Customer from '../components/Customer.vue'

const routes = [
  {
    path: '/product',
    name: 'Product',
    component: Product
  },
  {
    path: '/customer',
    name: 'Customer',
    component: Customer
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router