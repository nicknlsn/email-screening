<template>
    <div class="home">
        <p>Get a random joke by category:</p>
        <select v-model="category" title="select a joke category">
            <option value="select-category">Select category</option>
            <option v-for="categoryOption in categories" v-bind:value="categoryOption">{{categoryOption}}</option>
        </select>
        <button v-on:click="randomJoke()">Random joke</button>
        <p v-if="loadingJoke">Loading joke...</p>
        <p v-if="loadingCategories">Loading categories...</p>
        <p v-if="!loadingJoke && joke !== ''">{{joke}}</p>
        <p>Search for a joke:</p>
        <input v-model="searchQuery" placeholder="enter search query"/>
        <button type="submit" v-on:click="searchJokes()">Search</button>
        <p v-if="searching">Searching...</p>
        <p v-if="!searching && searchedJoke !== ''">{{searchedJoke}}</p>
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
        public searchQuery: string;
        public searchedJoke: string;
        public searching: boolean;

        constructor() {
            super();
            this.joke = '';
            this.loadingJoke = false;
            this.loadingCategories = false;
            this.loadCategories();
            this.categories = []; // so vue doesn't complain
            this.category = 'select-category';
            this.searchQuery = '';
            this.searchedJoke = '';
            this.searching = false;
        }

        public randomJoke() {
            if (this.category !== 'select-category') {
                this.loadingJoke = true;
                axios.get('/api/v1/chuck-norris-category', {
                    params: {
                        category: this.category,
                    },
                }).then((response) => {
                    this.joke = response.data;
                }).catch(() => {
                    this.joke = 'Chuck Norris is busy, please try again later.';
                }).then(() => {
                    this.loadingJoke = false;
                });
            } else {
                this.joke = 'You need to select a category first.';
            }
        }

        public searchJokes() {
            if ('' === this.searchQuery) {
                this.searchedJoke = 'You need to enter a search query';
            } else {
                this.searching = true;
                axios.get('/api/v1/chuck-norris-joke-search', {
                    params: {
                        value: this.searchQuery,
                    },
                }).then((response) => {
                    this.searchedJoke = response.data;
                }).catch(() => {
                    this.searchedJoke = 'There was an error, please try again later.';
                }).then(() => {
                    this.searching = false;
                })
            }
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
    }
</script>
