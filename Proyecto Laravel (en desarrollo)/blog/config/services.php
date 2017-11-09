<?php

return [

    /*
    |--------------------------------------------------------------------------
    | Third Party Services
    |--------------------------------------------------------------------------
    |
    | This file is for storing the credentials for third party services such
    | as Stripe, Mailgun, SparkPost and others. This file provides a sane
    | default location for this type of information, allowing packages
    | to have a conventional place to find your various credentials.
    |
    */

    'mailgun' => [
        'domain' => env('MAILGUN_DOMAIN'),
        'secret' => env('MAILGUN_SECRET'),
    ],

    'ses' => [
        'key' => env('SES_KEY'),
        'secret' => env('SES_SECRET'),
        'region' => 'us-east-1',
    ],

    'sparkpost' => [
        'secret' => env('SPARKPOST_SECRET'),
    ],

    'stripe' => [
        'model' => App\User::class,
        'key' => env('STRIPE_KEY'),
        'secret' => env('STRIPE_SECRET'),
    ],

    'google' => [
        'client_id' => '99077151383-74nskb7lsemt058h35u3pmuj2ce04ph6.apps.googleusercontent.com',
        'client_secret' => 'FXIQlPlOlAcgE1DCFxYLnm4E',
        'redirect' => 'http://localhost:8000/login/google/callback',
    ],
 
    'twitter' => [
        'client_id' => 'BiZ0UddqfohvnvkwPimE7lNb1',
        'client_secret' => 'E8XgTRa8PXF6xs69WLfWEAgaIj5LByKvJ8HT7LjcZMV7VgddWM',
        'redirect' => 'http://localhost:8000/login/twitter/callback',
    ],

    'facebook' => [
        'client_id' => '829236237239299',
        'client_secret' => '588128b80eea61ae95d55cbc0c9b8368',
        'redirect' => 'http://localhost:8000/login/facebook/callback',
    ],
];
