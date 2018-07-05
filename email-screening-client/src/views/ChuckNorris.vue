<template>
    <div class="home">
        <button v-on:click="chuck()">chuck norris</button>
        <p v-if="joke !== ''">{{joke}}</p>
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


        constructor() {
            super();
            this.joke = '';
        }

        public chuck() {
            axios.get('/api/v1/chuck-norris-category', {
                params: {
                    category: 'dev',
                },
            }).then((response) => {
                this.joke = response.data;
            })
        }
    }
</script>
