A class for building Gravatar URLs based on the [Gravatar implementation guide](http://gravatar.com/site/implement/url).

Sample usage: The following code prints out the URL to the Gravatar image based on the supplied email address:

    GravatarUrl gravatarUrl = new GravatarUrl("iHaveAn@email.com");
    System.out.println(gravatarUrl);
    
The above code outputs:

    http://www.gravatar.com/avatar/3b3be63a4c2a439b013787725dfce802.jpg

The optional size, rating and default icon settings are also supported. Constants for rating and default icon are provided for convenience.

    GravatarUrl gravatarUrl = new GravatarUrl("iHaveAn@email.com", 512, GravatarUrl.Rating.PG, GravatarUrl.DEFAULT_ICON_IDENTICON);
    System.out.println(gravatarUrl);

The above code outputs:

    http://www.gravatar.com/avatar/3b3be63a4c2a439b013787725dfce802.jpg?s=512&r=pg&d=identicon