<template>
    <div class="home">
        <input type="number" v-model="value" placeholder="enter an integer" autofocus>
        <!--<p>Message is: {{ value }}</p>-->
        <!--<button v-on:click="submit()">submit</button>-->
        <!--<button v-on:click="clear()">Clear</button>-->
        <div v-if="!empty">
            <p v-if="answer">{{value}} is a palindrome!</p>
            <p v-else="!answer">{{value}} is not a palindrome.</p>
            <p v-else="error">There was an error, please try again.</p>
        </div>
    </div>
</template>

<script lang="ts">
    import { Component, Vue, Watch } from 'vue-property-decorator';
    import HelloWorld from '@/components/HelloWorld.vue'; // @ is an alias to /src
    import axios from 'axios';

    @Component({
        components: {
            HelloWorld,
        },
    })
    export default class IntegerPalindrome extends Vue {

        public value: string;
        public answer: boolean;
        public empty: boolean;
        public error: boolean;

        constructor() {
            super();
            this.value = '';
            this.answer = false;
            this.empty = true;
            this.error = false;
        }

        public submit() {
            axios.get('/api/v1/integer-palindrome', {
                params: {
                    value: this.value,
                },
            }).then((response) => {
                this.empty = false;
                this.answer = response.data;
            }).catch(() => {
                this.error = true;
            });
        }

        public clear() {
            this.empty = true;
            this.value = '';
        }

        @Watch('value') public onValueChanged() {
            this.empty = true;

            if (this.value === '') {
                this.clear();
            } else {
                this.submit();
            }
        }
    }
</script>
