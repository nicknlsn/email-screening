import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';
import ChuckNorris from './views/ChuckNorris.vue';
import UniqueTraversal from './views/UniqueTraversal.vue';

Vue.use(Router);

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            name: 'home',
            component: Home,
        },
        {
            path: '/ChuckNorris',
            name: 'chuck-norris',
            component: ChuckNorris,
        },
        {
            path: '/UniqueTraversal',
            name: 'unique-traversal',
            component: UniqueTraversal,
        },
    ],
});
