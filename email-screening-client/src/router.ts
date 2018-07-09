import Vue from 'vue';
import Router from 'vue-router';
import ChuckNorris from './views/ChuckNorris.vue';
import UniqueTraversal from './views/UniqueTraversal.vue';
import IntegerPalindrome from './views/IntegerPalindrome.vue';

Vue.use(Router);

export default new Router({
    // mode: 'history',
    routes: [
        {
            path: '/',
            name: 'integer-palindrome',
            component: IntegerPalindrome,
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
