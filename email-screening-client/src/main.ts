import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import './registerServiceWorker';
import axios from 'axios';

Vue.config.productionTip = false;

new Vue({
    router,
    store,
    render: (h) => h(App),
}).$mount('#app');

// use this interceptor to change all requests that start with /api during development to go to the local backend server
axios.interceptors.request.use((config) => {
    if (config && config.url && config.url.startsWith('/api')) {
        config.url = 'http://localhost:8080' + config.url;
    }
    return config;
}, (error) => {
    return Promise.reject(error);
});
