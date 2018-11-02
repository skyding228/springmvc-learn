# Initialize process

1. `Listener -> Filter -> servlet`  regardless the position in web.xml
2. initialize different `Listeners/Filters/Servlets` based on the configured position in web.xml one by one.
3. If more than one Listener which have the same class type, only one is effective.