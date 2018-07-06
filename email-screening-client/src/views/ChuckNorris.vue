<template>
    <div class="home">
        <select v-model="category" title="select a joke category">
            <option value="select-category">Select category</option>
            <option v-for="categoryOption in categories" v-bind:value="categoryOption">{{categoryOption}}</option>
        </select>
        <button v-on:click="chuck()">Random joke</button>
        <p v-if="loadingJoke">Loading joke...</p>
        <p v-if="loadingCategories">Loading categories...</p>
        <p v-if="!loadingJoke && joke !== ''">{{joke}}</p>
    </div>
</template>

<script lang="ts">
    import { Component, Vue } from 'vue-property-decorator';
    import HelloWorld from '@/components/HelloWorld.vue'; // @ is an alias to /src
    import axios from 'axios';

    @Component({
        components: {
            HelloWorld,
        },
    })
    export default class ChuckNorris extends Vue {

        public joke: string;
        public loadingJoke: boolean;
        public loadingCategories: boolean;
        public categories: string[];
        public category: string;

        constructor() {
            super();
            this.joke = '';
            this.loadingJoke = false;
            this.loadingCategories = false;
            this.loadCategories();
            this.categories = []; // so vue doesn't complain
            this.category = 'select-category';
        }

        private loadCategories() {
            this.loadingCategories = true;

            axios.get<string[]>('/api/v1/chuck-norris-categories').then((response) => {
                response.data.forEach((datum) => this.categories.push(datum));
            }).catch(() => {
                // just do this if an error occurred
                [
                    'explicit',
                    'dev',
                    'movie',
                    'food',
                    'celebrity',
                    'science',
                    'sport',
                    'political',
                    'religion',
                    'animal',
                    'history',
                    'music',
                    'travel',
                    'career',
                    'money',
                    'fashion',
                ].forEach((category) => this.categories.push(category));
            }).then(() => {
                this.loadingCategories = false;
            });
        }

        public chuck() {
            this.loadingJoke = true;

            axios.get('/api/v1/chuck-norris-category', {
                params: {
                    category: 'dev',
                },
            }).then((response) => {
                this.joke = response.data;
            }).catch(() => {
                this.joke = 'Chuck Norris is busy, please try again later.';
            }).then(() => {
                this.loadingJoke = false;
            });
        }
    }
</script>
