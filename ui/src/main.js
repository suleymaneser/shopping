import { createApp } from 'vue'
import App from './App.vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import VueAxios from "vue-axios";
import axios from 'axios'
//import router from './router'

//axios.default.baseURL = 'http://localhost:8080/'
createApp(App).use(VueAxios, axios).mount('#app')
