ui:
	LEIN_ROOT=1 lein clean
	LEIN_ROOT=1 lein less once
	LEIN_ROOT=1 lein with-profile rel cljsbuild once

package: ui
	make -C rel/pkg package
