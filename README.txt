This small project demonstrates an issue with 2D hardware acceleration that
doesn't seem to be mentioned in the Android SDK documentation. Scaling a
canvas with hardware acceleration enabled yields a totally wrong result:
A circle is turned into a blurry square entitiy.